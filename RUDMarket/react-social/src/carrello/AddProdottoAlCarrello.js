import React, { Component } from 'react';
import './Carrello.css'
import {Redirect} from "react-router-dom";
import {addProdottoInCarrello} from "../util/APIUtils";
import Alert from "react-s-alert";

class AddProdottoAlCarrello extends Component {
    constructor(props) {
        super(props);
        this.state = {
            idProdotto: this.props.location.idProdotto
        }

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        const addProdottoInCarrelloRequest = Object.assign({}, this.state);
        addProdottoInCarrello(addProdottoInCarrelloRequest)
            .then(response => {

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
                            <h1>{this.props.location.nomeProdotto}</h1>
                            <input type="text" className="form-control"
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