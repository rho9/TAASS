import React, { Component } from 'react';
import { addSezione } from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class AddSupermercato extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nomeSezione: '',
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeTitle(event) {
        this.setState({nomeSezione: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const addSezioneRequest = Object.assign({}, this.state);
        addSezione(addSezioneRequest)
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
                                    <label htmlFor="firstName">Nome Sezione</label>
                                    <input type="text" className="form-control"
                                           name="nomeSezione"
                                           value={this.state.nomeSezione}
                                           onChange={this.handleChangeTitle}
                                           required/>
                                    <div className="invalid-feedback">
                                        È necessario inserire il nome di una sezione
                                    </div>
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