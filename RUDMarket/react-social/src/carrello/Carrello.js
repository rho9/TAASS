import React, { Component } from 'react';
import './Carrello.css'

import ProdottiInCarrello from "./ProdottiInCarrello";
import {getProdottiInCarrello} from "../util/APIUtils";
import CostoTotale from "./CostoTotale";
import {getCostoTotale} from "../util/APIUtils";
import {NavLink} from "react-router-dom";
import ShoppingCartIcon from "@material-ui/core/SvgIcon/SvgIcon";

class Carrello extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodottiInCarrello: [],
            costoTotale: 0
        }

        getProdottiInCarrello()
            .then(response => {
                this.setState({
                    prodottiInCarrello: response
                });
            })

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
            </body>
        );
    }
}

export default Carrello;