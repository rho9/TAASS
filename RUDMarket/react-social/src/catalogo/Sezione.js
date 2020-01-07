import React, { Component } from 'react';
import './Sezione.css';
import ProdottoList from "./ProdottoList";
import {API_BASE_URL} from "../constants";

class Sezione extends Component {
    constructor(props) {
        super(props);
        //alert(this.props.location.prodottoList);
        this.state = {
            prodotti: this.props.location.prodottoList
        }

        //this.componentDidMount.bind(this)
        this.setState({prodotti : this.props.location.prodottoList})
    }

    /*componentDidMount() {
        fetch(API_BASE_URL + '/sezione/getProdottiByIdSezione', {
            method: 'POST',
            body: this.props.location.idSezione
        })
            .then(res => res.json())
            .then((data) => {
                this.setState({ prodotti: data })
            })
    }*/

    render() {
        return(
            <body>
                <div className="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 className="display-4">{this.props.location.nomeSezione}</h1>
                    <a href="/catalogo" className="btn btn-warning">Torna al Catalogo</a>
                </div>

                <div className="container">
                    <div className="card-deck mb-3 text-center">
                        <ProdottoList prodotti={this.state.prodotti} />
                    </div>
                </div>
            </body>
        );
    }
}

export default Sezione;