import React, { Component } from 'react';
import './Sezione.css';
import ProdottoList from "./ProdottoList";

class Sezione extends Component {
    constructor(props) {
        super(props);

        let prod;
        if(this.props.location.prodottoList){
            localStorage.setItem('prodottoList', JSON.stringify(this.props.location.prodottoList));
            prod = this.props.location.prodottoList
        } else {
            prod = localStorage.getItem('prodottoList');
            if(prod) prod = JSON.parse(prod)
        }

        let nomeS;
        if(this.props.location.nomeSezione){
            localStorage.setItem('nomeSezione', JSON.stringify(this.props.location.nomeSezione));
            nomeS = this.props.location.nomeSezione
        } else {
            nomeS = localStorage.getItem('nomeSezione');
            if(nomeS) nomeS = JSON.parse(nomeS)
        }

        this.state = {
            prodotti: prod,
            nomeSezione: nomeS
        };
    }

    render() {
        return(
            <body>
                <div className="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                    <h1 className="display-4">{this.state.nomeSezione}</h1>
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