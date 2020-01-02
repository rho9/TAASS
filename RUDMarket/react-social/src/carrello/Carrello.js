import React, { Component } from 'react';
import './Carrello.css'

import ProdottiInCarrello from "./ProdottiInCarrello";
import {getProdottiInCarrello} from "../util/APIUtils";
import CostoTotale from "./CostoTotale";
import {getCostoTotale} from "../util/APIUtils";
import NavLink from "react-router-dom/NavLink";
import Ricette from "./Ricette";

class Carrello extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodottiInCarrello: [],
            costoTotale: 0,
            prodottiRicette: {},
        }

        getProdottiInCarrello()
            .then(response => {
                this.setState({
                    prodottiInCarrello: response
                });

                // TODO: chiama la funzione per ricevere le ricette e setta la map correttamente, per ora è uno stub

                let ricette = this.state.prodottiRicette;
                ricette['Carota'] = ['Ricetta con Carota 1', 'Ricetta con Carota 2'];
                //ricette['Cavolo'] = ['Ricetta con Cavolo 1'];
                this.setState({prodottiRicette : ricette});
            });

        getCostoTotale()
            .then(response => {
                this.setState({
                    costoTotale: response
                });
            })
    }

    render() {
        return (
            <body>
            <section class="jumbotron text-center">
            <h2>Il tuo RUDCarrello</h2>
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Quantità</th>
                        <th>Prodotto</th>
                        <th>Marca</th>
                        <th>Prezzo unitario</th>
                        <th>Prezzo totale</th>
                    </tr>
                    </thead>
                    <ProdottiInCarrello prodottiInCarrello={this.state.prodottiInCarrello} />
                    <CostoTotale costoTotale={this.state.costoTotale}/>
                </table>
            </div>
            <div className="text-right">
                <form>
                    { this.state.costoTotale !== 0 ? (
                        <NavLink className="btn btn-warning" to="/pagamento">Paga</NavLink>
                    ) :
                        <button className="btn btn-warning" disabled>Paga</button>
                    }
                </form>
            </div>
            </section>

            {
                Object.keys(this.state.prodottiRicette).length > 0 ? (
                    <Ricette ricette={this.state.prodottiRicette} chiavi={Object.keys(this.state.prodottiRicette)} />
                ) : (
                    <section className="jumbotron text-center">
                        <h2>Nessuna Ricetta</h2>
                    </section>
                )
            }

            </body>
        );
    }
}

export default Carrello;