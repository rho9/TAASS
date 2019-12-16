import React, { Component } from 'react';
import './Pagamento.css';
import {NavLink} from "react-router-dom";
import ProdottiDaPagare from "./ProdottiDaPagare";
import {getCostoTotale, getProdottiInCarrello} from "../util/APIUtils";
import PagamentoTotale from "./PagamentoTotale";

class Pagamento extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodottiDaPagare: [],
            pagamentoTotale: 0
        }

        getProdottiInCarrello()
            .then(response => {
                this.setState({
                    prodottiDaPagare: response
                });
            })

        getCostoTotale()
            .then(response => {
                this.setState({
                    pagamentoTotale: response
                });
            })
    }

    render() {
        return (
            <body class="bg-light">
            <div className="container">
                <div className="py-5 text-center">
                    <h1>RUDMarket</h1>
                </div>
                <div class="row">
                    <div className="col-md-4 order-md-2 mb-4">
                        <h4 className="d-flex justify-content-between align-items-center mb-3">
                            <span className="text-muted">Il tuo RUDCarrello</span>
                            <span className="badge badge-secondary badge-pill">3</span>
                        </h4>
                        <ul className="list-group mb-3">
                            <ProdottiDaPagare prodottiDaPagare={this.state.prodottiDaPagare}/>
                            <li className="list-group-item d-flex justify-content-between bg-light">
                                <div className="text-success">
                                    <h6 className="my-0">Promo code</h6>
                                    <small>EXAMPLECODE</small>
                                </div>
                                <span className="text-success">-$5</span>
                            </li>
                            <PagamentoTotale pagamentoTotale={this.state.pagamentoTotale}/>
                        </ul>

                        <form className="card p-2">
                            <div className="input-group">
                                <div className="input-group-append">
                                    <button type="submit" className="btn btn-secondary">Paga</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div className="col-md-8 order-md-1">
                        <h4 className="mb-3">Pagamento</h4>

                        <div className="d-block my-3">
                            <div className="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" className="custom-control-input"
                                       checked required/>
                                    <label className="custom-control-label" htmlFor="credit">Carta di credito</label>
                            </div>
                            <div className="custom-control custom-radio">
                                <input id="debit" name="paymentMethod" type="radio" className="custom-control-input"
                                       required/>
                                    <label className="custom-control-label" htmlFor="debit">Carta di debito</label>
                            </div>
                            <div className="custom-control custom-radio">
                                <input id="paypal" name="paymentMethod" type="radio" className="custom-control-input"
                                       required/>
                                    <label className="custom-control-label" htmlFor="paypal">Paypal</label>
                            </div>
                        </div>
                            <div className="col-md-6 mb-3">
                                <label htmlFor="cc-name">Intestatario della carta</label>
                                <input type="text" className="form-control" id="cc-name" placeholder="" required></input>
                                    <small className="text-muted">Nome completo presente sulla carta</small>
                                    <div className="invalid-feedback">
                                        Name on card is required
                                    </div>
                            </div>
                            <div className="col-md-6 mb-3">
                                <label htmlFor="cc-number">Numero della carta</label>
                                <input type="text" className="form-control" id="cc-number" placeholder="" required></input>
                                    <div className="invalid-feedback">
                                        Credit card number is required
                                    </div>
                            </div>
                        <div className="row">
                            <div className="col-md-3 mb-3">
                                <label htmlFor="cc-expiration">Scadenza</label>
                                <input type="text" className="form-control" id="cc-expiration" placeholder="" required></input>
                                    <div className="invalid-feedback">
                                        Expiration date required
                                    </div>
                            </div>
                            <div className="col-md-3 mb-3">
                                <label htmlFor="cc-expiration">CVV</label>
                                <input type="text" className="form-control" id="cc-cvv" placeholder="" required></input>
                                    <div className="invalid-feedback">
                                        Security code required
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </body>
        )
    }
}

export default Pagamento;