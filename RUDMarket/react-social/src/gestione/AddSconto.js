import React, { Component } from 'react';
import {addSconto, findUtenti, getSezioni} from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class AddSconto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cercaEmailUtente: '',
            emailUtente: '',
            utentiTrovati: [],
            perc: '',
            selectedSezione: '',
            sezioni: [],
            prodotti: [],
            selectedProdotto: '',
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeSezione = this.handleChangeSezione.bind(this);

        getSezioni()
            .then(data => {
                let sezioniFromApi = data.map(sezione => { return {value: sezione.id, display: sezione.nome} })
                this.setState({ sezioni: [].concat(sezioniFromApi) });
                this.setState({ selectedSezione: this.state.sezioni[0].value})
                fetch('http://localhost:8080/sezione/getProdottiByIdSezione', {
                    method: 'POST',
                    body: this.state.selectedSezione
                })
                    .then(res => res.json())
                    .then((data) => {
                        let prodottiFromApi = data.map(prodotto => { return {value: prodotto.id, display: prodotto.nome + " - " + prodotto.marca} })
                        this.setState({ prodotti: [].concat(prodottiFromApi) });
                        this.setState({ selectedProdotto: this.state.prodotti[0].value})
                    })
            })
    }

    handleChangeTitle(event) {
        this.setState({emailUtente: event.target.value});
    }

    handleChangeSezione(event) {
        this.setState({selectedSezione: event.target.value})
        fetch('http://localhost:8080/sezione/getProdottiByIdSezione', {
            method: 'POST',
            body: event.target.value
        })
            .then(res => res.json())
            .then((data) => {
                let prodottiFromApi = data.map(prodotto => { return {value: prodotto.id, display: prodotto.nome + " - " + prodotto.marca} })
                this.setState({ prodotti: [].concat(prodottiFromApi) });
                if (this.state.prodotti.length > 0) {
                    this.setState({selectedProdotto: this.state.prodotti[0].value})
                }

            })
    }

    handleSubmit(event) {
        event.preventDefault();
        const addScontoRequest = Object.assign({}, this.state);
        addSconto(addScontoRequest)
            .then(response => {
                this.props.history.push("/gestione")
            }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });
    }

    render() {
        return (
            <div className="container">
                <div className="py-5 text-center">
                    <h2>Inserimento Sconto</h2>
                </div>
                <div className="row">
                    <div className="col-md-8 order-md-1">
                        <form onSubmit={this.handleSubmit}>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="cercaEmailUtente">Cerca Email Utente</label>
                                    <input type="text" className="form-control"
                                           name="cercaEmailUtente"
                                           value={this.state.cercaEmailUtente}
                                           //onChange={this.handleChangeCercaUtente}
                                           onChange={
                                               (e) => {
                                                   this.setState({cercaEmailUtente: e.target.value})
                                                   findUtenti(e.target.value)
                                                       .then(data => {
                                                           let utentiTrovatiFromApi = data.map(utenteTrovato => { return {value: utenteTrovato, display: utenteTrovato} })
                                                           this.setState({ utentiTrovati: [].concat(utentiTrovatiFromApi) })
                                                           if (this.state.utentiTrovati.length > 0) {
                                                               this.setState({emailUtente: this.state.utentiTrovati[0].value})
                                                           }
                                                       })
                                               }
                                           }
                                           required/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Email Utente</label>
                                    <select className="custom-select d-block w-100" value={this.state.emailUtente}
                                            onChange={(e) => this.setState({emailUtente: e.target.value})}>
                                        {this.state.utentiTrovati.map((utenteTrovato) => <option key={utenteTrovato.value} value={utenteTrovato.value}>{utenteTrovato.display}</option>)}>
                                    </select>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="percentuale">Percentuale</label>
                                    <div className="input-group">
                                        <input type="text" className="form-control"
                                               name="percentuale"
                                               value={this.state.perc}
                                               onChange={(e) => this.setState({perc: e.target.value})}
                                               required/>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Sezione</label>
                                    <select className="custom-select d-block w-100" value={this.state.selectedSezione}
                                            onChange={this.handleChangeSezione}>
                                        {this.state.sezioni.map((sezione) => <option key={sezione.value} value={sezione.value}>{sezione.display}</option>)}>
                                    </select>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Prodotto</label>
                                    <select className="custom-select d-block w-100" value={this.state.selectedProdotto}
                                            onChange={(e) => this.setState({selectedProdotto: e.target.value})}>
                                        {this.state.prodotti.map((prodotto) => <option key={prodotto.value} value={prodotto.value}>{prodotto.display}</option>)}>
                                    </select>
                                </div>
                            </div>
                            <button className="btn btn-warning " type="submit">Aggiungi</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default AddSconto;