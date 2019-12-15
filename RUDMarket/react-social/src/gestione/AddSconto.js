import React, { Component } from 'react';
import { addProdotto } from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class AddSconto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nomeUtente: '',
            perc: '',
            selectedSezione: '',
            sezioni: [],
            prodotti: [],
            selectedProdotto: '',

        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChangeSezione = this.handleChangeSezione.bind(this)
    }

    handleChangeTitle(event) {
        this.setState({nome: event.target.value});
    }

    handleChangeSezione(event) {
        this.setState({selectedSezione: event.target.value})
        fetch('http://localhost:8080/sezione/getProdottiByIdSezione', {
            method: 'POST',
            body: "id=" + event.target.value
        })
            .then(res => res.json())
            .then((data) => {
                let prodottiFromApi = data.map(prodotto => { return {value: prodotto.id, display: prodotto.nome + " - " + prodotto.marca} })
                this.setState({ prodotti: [{value: '', display: '(Seleziona il nome del Prodotto)'}].concat(prodottiFromApi) });
            })
    }

    handleSubmit(event) {
        event.preventDefault();

        const addProdottoRequest = Object.assign({}, this.state);
        addProdotto(addProdottoRequest)
            .then(response => {
                this.props.history.push("/gestione")
            }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });
    }

    componentDidMount() {
        fetch("http://localhost:8080/sezione/getSezioni")
            .then((response) => {
                return response.json();
            })
            .then(data => {
                let sezioniFromApi = data.map(sezione => { return {value: sezione.id, display: sezione.nome} })
                this.setState({ sezioni: [{value: '', display: '(Seleziona il nome della Sezione)'}].concat(sezioniFromApi) });
            }).catch(error => {
            console.log(error);
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
                                    <label htmlFor="firstName">Nome Utente</label>
                                    <input type="text" className="form-control"
                                           name="nomeSezione"
                                           value={this.state.nomeUtente}
                                           onChange={this.handleChangeTitle}
                                           required/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Percentuale</label>
                                    <div className="input-group">
                                        <input type="text" className="form-control"
                                               name="nomeSezione"
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

export default AddSconto