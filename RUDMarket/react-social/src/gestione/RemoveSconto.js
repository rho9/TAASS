import React, { Component } from 'react';
import {findScontiByUtente, findUtenti, removeSconto} from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class RemoveSconto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cercaEmailUtente: '',
            emailUtente: '',
            utentiTrovati: [],
            scontiTrovati: [],
            scontoSelezionato: '',
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeTitle(event) {
        this.setState({emailUtente: event.target.value});
    }

    handleSubmit(event) {
        removeSconto(this.state.scontoSelezionato)
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
                    <h2>Rimozione Sconto</h2>
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
                                           onChange={
                                               (e) => {
                                                   this.setState({cercaEmailUtente: e.target.value})
                                                   findUtenti(e.target.value)
                                                       .then(data => {
                                                           let utentiTrovatiFromApi = data.map(utenteTrovato => { return {value: utenteTrovato, display: utenteTrovato} })
                                                           this.setState({ utentiTrovati: [{value: '', display: '(Seleziona Utente)'}].concat(utentiTrovatiFromApi) })
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
                                            onChange={
                                                (e) => {
                                                    this.setState({emailUtente: e.target.value})
                                                    findScontiByUtente(e.target.value)
                                                        .then(data => {
                                                            let scontiTrovatiFromApi = data.map(scontoTrovato => { return {value: scontoTrovato.id, display: scontoTrovato.prodotto.nome + " - " + scontoTrovato.prodotto.marca} })
                                                            this.setState({ scontiTrovati: [{value: '', display: '(Seleziona Sconto)'}].concat(scontiTrovatiFromApi) })
                                                        })
                                                }
                                            }>
                                        {this.state.utentiTrovati.map((utenteTrovato) => <option key={utenteTrovato.value} value={utenteTrovato.value}>{utenteTrovato.display}</option>)}>
                                    </select>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Sconti</label>
                                    <select className="custom-select d-block w-100" value={this.state.scontoSelezionato}
                                            onChange={
                                                (e) => {
                                                    this.setState({scontoSelezionato: e.target.value})
                                                }
                                            }>
                                        {this.state.scontiTrovati.map((sconto) => <option key={sconto.value} value={sconto.value}>{sconto.display}</option>)}>
                                    </select>
                                </div>
                            </div>
                            <button className="btn btn-warning " type="submit">Rimuovi</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default RemoveSconto