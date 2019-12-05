import React, { Component } from 'react';
import { addSezione } from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class AddSezione extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nome: '',
            sezioni: []
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        fetch('http://localhost:8080/sezione/getSezioni')
            .then(res => res.json())
            .then((data) => {
                this.setState({ sezioni: data })
            })
    }

    handleChangeTitle(event) {
        this.setState({nome: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const addSezioneRequest = Object.assign({}, this.state);
        addSezione(addSezioneRequest)
            .then(response => {
                Alert.success("Sezione aggiunta correttamente!");

            }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });
    }

    render() {
        return (
            <div className="container">
                <div className="py-5 text-center">
                    <h2>Inserimento Sezione</h2>
                </div>
                <div className="row">
                    <div className="col-md-8 order-md-1">
                        <form className="needs-validation" noValidate>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="firstName">Nome Sezione</label>
                                    <input type="text" className="form-control" placeholder="" value="" required/>
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
            /*<div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Nome Sezione:
                        <input
                            type="text"
                            value={this.state.nome}
                            onChange={this.handleChangeTitle}/>
                    </label>
                    <input type="submit" value="Aggiungi"/>
                </form>

            </div>*/
        );
    }
}

export default AddSezione