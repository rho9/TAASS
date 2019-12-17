import React, { Component } from 'react';
import { addProdotto } from '../util/APIUtils';
import Alert from 'react-s-alert';
import './form-validation.css'

class AddProdotto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nome: '',
            marca: '',
            prezzo: '',
            atKg: false,
            sezioni: [],
            selectedSezione: '',
            validationError: ''
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        fetch("http://localhost:8080/sezione/getSezioni")
            .then((response) => {
                return response.json();
            })
            .then(data => {
                let sezioniFromApi = data.map(sezione => { return {value: sezione.id, display: sezione.nome} })
                this.setState({ sezioni: [].concat(sezioniFromApi) });
                this.setState({ selectedSezione: this.state.sezioni[0].value});
            }).catch(error => {
            console.log(error);
        });
    }

    handleChangeTitle(event) {
        this.setState({nome: event.target.value});
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

    render() {
        return (
            <div className="container">
                <div className="py-5 text-center">
                    <h2>Inserimento Prodotto</h2>
                </div>
                <div className="row">
                    <div className="col-md-8 order-md-1">
                        <form onSubmit={this.handleSubmit}>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="firstName">Nome Prodotto</label>
                                    <input type="text" className="form-control"
                                           name="nomeSezione"
                                           value={this.state.nome}
                                           onChange={this.handleChangeTitle}
                                           required/>
                                    <div className="invalid-feedback">
                                        È necessario inserire il nome di una sezione
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Marca Prodotto</label>
                                    <div className="input-group">
                                        <input type="text" className="form-control"
                                               name="nomeSezione"
                                               value={this.state.marca}
                                               onChange={(e) => this.setState({marca: e.target.value})}
                                               required/>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Prezzo</label>
                                    <div className="input-group">
                                        <input type="text" className="form-control"
                                               name="nomeSezione"
                                               value={this.state.prezzo}
                                               onChange={(e) => this.setState({prezzo: e.target.value})}
                                               required/>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <div className="custom-control custom-checkbox">
                                        <input type="checkbox" className="custom-control-input"
                                               name="alKg"
                                               id="kgCheck"
                                               checked={this.state.atKg}
                                               onChange={(e) => this.setState({atKg: e.target.checked})} />
                                        <label className="custom-control-label" htmlFor="kgCheck">Prezzo al KG</label>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-md-6 mb-3">
                                    <label htmlFor="username">Sezione</label>
                                    <select className="custom-select d-block w-100" value={this.state.selectedSezione}
                                            onChange={(e) => this.setState({selectedSezione: e.target.value})}>
                                        {this.state.sezioni.map((sezione) => <option key={sezione.value} value={sezione.value}>{sezione.display}</option>)}>
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

export default AddProdotto