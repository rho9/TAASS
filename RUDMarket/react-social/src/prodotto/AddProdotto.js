import React, { Component } from 'react';
import { addProdotto } from '../util/APIUtils';
import Alert from 'react-s-alert';

class AddProdotto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nome: '',
            marca: '',
            sezioni: [],
            selectedSezione: '',
            validationError: ''
        }
        console.log(props);

        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeSteps = this.handleChangeSteps.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount() {
        fetch("http://localhost:8080/sezione/getSezioni")
            .then((response) => {
                return response.json();
            })
            .then(data => {
                let sezioniFromApi = data.map(sezione => { return {value: sezione.id, display: sezione.nome} })
                this.setState({ sezioni: [{value: '', display: '(Seleziona la Sezione del Sezione)'}].concat(sezioniFromApi) });
            }).catch(error => {
            console.log(error);
        });
    }

    handleChangeTitle(event) {
        this.setState({nome: event.target.value});
    }
    
    handleChangeSteps(event) {
        this.setState({marca: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        const addProdottoRequest = Object.assign({}, this.state);
        addProdotto(addProdottoRequest)
            .then(response => {
                Alert.success("Sezione aggiunto correttamente!");

            }).catch(error => {
                Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
            });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                Nome Prodotto:
                <input
                    type="text"
                    value={this.state.nome}
                    onChange={this.handleChangeTitle}/>
                </label>
                <label>
                Marca Prodotto:
                <input
                    type="text"
                    value={this.state.marca}
                    onChange={this.handleChangeSteps}/>
                </label>
                <select value={this.state.selectedSezione}
                        onChange={(e) => this.setState({selectedSezione: e.target.value})}>
                    {this.state.sezioni.map((sezione) => <option key={sezione.value} value={sezione.value}>{sezione.display}</option>)}
                </select>
                <input type="submit" value="Aggiungi"/>
            </form>
        );
    }
}

export default AddProdotto