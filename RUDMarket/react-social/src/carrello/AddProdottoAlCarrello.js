import React, { Component } from 'react';
import './Carrello.css'
import {addProdottoInCarrello} from "../util/APIUtils";
import Alert from "react-s-alert";

class AddProdottoAlCarrello extends Component {
    constructor(props) {
        super(props);
        this.state = {
            idProdotto: this.props.location.idProdotto,
            quantita: 1
        }

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        const addProdottoInCarrelloRequest = Object.assign({}, this.state);
        addProdottoInCarrello(addProdottoInCarrelloRequest)
            .then(response => {
                this.props.history.push("/catalogo")
            }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });
    }

    render() {
        return(
            <div className="container">
                <div className="py-5 text-center">
                    <h2>Vuoi aggiungere al carrello</h2>
                </div>
                <form onSubmit={this.handleSubmit}>
                    <div className="row">
                        <div className="col-md-6 mb-3">
                            {this.props.location.atKg ? (
                                <h1>{this.props.location.nomeProdotto} / kg</h1>
                            ) : (
                                <h1>{this.props.location.nomeProdotto}</h1>
                            )}
                            {this.props.location.atKg ? (
                                <input type="number" className="form-control"
                                       name="quantita"
                                       min=".1"
                                       step=".1"
                                       value={this.state.quantita}
                                       onChange={(e) => this.setState({quantita: e.target.value})}
                                       required/>
                            ) : (
                                <input type="number" className="form-control"
                                       name="quantita"
                                       min="1"
                                       value={this.state.quantita}
                                       onChange={(e) => this.setState({quantita: e.target.value})}
                                       required/>
                            )}
                            <input type="hidden" className="form-control"
                                   name="idProdotto"
                                   value={this.props.location.idProdotto}
                                   required/>
                        </div>
                    </div>
                    <button className="btn btn-warning " type="submit">Aggiungi</button>
                </form>
            </div>
        )
    }
}

export default AddProdottoAlCarrello;