import React, { Component } from 'react';
import {addSupermercato} from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class AddSupermercato extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nomeSupermercato: '',
            lat: '',
            lng: '',
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeTitle(event) {
        this.setState({nomeSupermercato: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const addSupermercatoRequest = Object.assign({}, this.state);
        addSupermercato(addSupermercatoRequest)
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
                    <h2>Inserimento Supermercato</h2>
                </div>
                <div className="row">
                    <div className="col-md-8 order-md-1">
                        <form onSubmit={this.handleSubmit}>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="firstName">Nome Supermercato</label>
                                    <input type="text" className="form-control"
                                           value={this.state.nomeSupermercato}
                                           onChange={this.handleChangeTitle}
                                           required/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="firstName">Latitudine</label>
                                    <input type="text" className="form-control"
                                           value={this.state.lat}
                                           onChange={
                                               (e) => {
                                                   this.setState({lat: e.target.value})
                                               }
                                           }
                                           required/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="firstName">Longitudine</label>
                                    <input type="text" className="form-control"
                                           value={this.state.lng}
                                           onChange={
                                               (e) => {
                                                   this.setState({lng: e.target.value})
                                               }
                                           }
                                           required/>
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

export default AddSupermercato