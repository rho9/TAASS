import React, { Component } from 'react';
import './Pagamento.css';
import ProdottiDaPagare from "./ProdottiDaPagare";
import {addOrdine, effettuaPagamento, getCostoTotale, getProdottiInCarrello, getSupermercati} from "../util/APIUtils";
import PagamentoTotale from "./PagamentoTotale";
import Alert from "react-s-alert";
import {GoogleMap, LoadScript, Marker} from "@react-google-maps/api";
import {GOOGLE_MAPS_API_KEY} from "../constants";

class Pagamento extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodottiDaPagare: [],
            pagamentoTotale: 0,
            creditChecked: false,
            debitChecked: false,
            paypalChecked: false,
            intestatarioCarta: '',
            numeroCarta: '',
            scadenzaCarta: '',
            cvvCarta: '',
            indirizzoChecked: false,
            supermercatoChecked: false,
            markers: [],
            supermercati: [],
            selectedSupermercato: '',
            selectedMarker: '',
            indirizzo: '',
            nome: '',
            cognome: '',
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

        getSupermercati()
            .then(data => {
                let markersFromApi = data.map(m => { return {lat: m.lat, lng: m.lng} })
                this.setState({ markers: [].concat(markersFromApi) })
                this.setState({selectedMarker: this.state.markers[0]})
                let supFromApi = data.map(sup => { return {value: sup.id, display: sup.nome} })
                this.setState({ supermercati: [].concat(supFromApi) })
                this.setState({selectedSupermercato: this.state.supermercati[0].value})
            })

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        let toSend = {
            nome: this.state.nome,
            cognome: this.state.cognome,
            indirizzo: this.state.indirizzo,
            selectedSupermercato: this.state.selectedSupermercato,
            indirizzoChecked: this.state.indirizzoChecked,
            supermercatoChecked: this.state.supermercatoChecked
        }

        const addOrdineRequest = Object.assign({}, toSend);
        addOrdine(addOrdineRequest)
            .then(response => {
                this.props.history.push("/")
            }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });


        const effettuaPagamentoRequest = Object.assign({}, this.state);
        effettuaPagamento(effettuaPagamentoRequest)
            .then(response => {
                this.props.history.push("/")
            }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });
    }

    render() {
        return (
            <body class="bg-light">
            <div className="container">
                <div className="py-5 text-center">
                    <h1>RUDMarket</h1>
                </div>
                <div>
                    <div className="row">
                        <div className="col-md-6 mb-3">
                            <label htmlFor="cc-name">Nome</label>
                            <input type="text"
                                   className="form-control"
                                   value={this.state.nome}
                                   onChange={(e) => {
                                       this.setState({nome: e.target.value})
                                   }}
                                   required/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-6 mb-3">
                            <label htmlFor="cc-name">Cognome</label>
                            <input type="text"
                                   className="form-control"
                                   value={this.state.cognome}
                                   onChange={(e) => {
                                       this.setState({cognome: e.target.value})
                                   }}
                                   required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div className="col-md-8 order-md-1">
                        <h4 className="mb-3">Pagamento</h4>
                        <div className="d-block my-3">
                            <div className="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" className="custom-control-input"
                                       checked={this.state.creditChecked}
                                       onClick={(e) => this.setState(
                                           {
                                               creditChecked: !this.state.creditChecked,
                                               debitChecked: false,
                                               paypalChecked: false,
                                           }
                                           )} required/>
                                    <label className="custom-control-label" htmlFor="credit">Carta di credito</label>
                            </div>
                            <div className="custom-control custom-radio">
                                <input id="debit" name="paymentMethod" type="radio" className="custom-control-input"
                                       checked={this.state.debitChecked}
                                       onClick={(e) => this.setState(
                                           {
                                               creditChecked: false,
                                               debitChecked: !this.state.debitChecked,
                                               paypalChecked: false,
                                           }
                                       )} required/>
                                    <label className="custom-control-label" htmlFor="debit">Carta di debito</label>
                            </div>
                            <div className="custom-control custom-radio">
                                <input id="paypal" name="paymentMethod" type="radio" className="custom-control-input"
                                       checked={this.state.paypalChecked}
                                       onClick={(e) => this.setState(
                                           {
                                               creditChecked: false,
                                               debitChecked: false,
                                               paypalChecked: !this.state.paypalChecked,
                                           }
                                       )} required/>
                                    <label className="custom-control-label" htmlFor="paypal">Paypal</label>
                            </div>
                        </div>
                            <div className="col-md-6 mb-3">
                                <label htmlFor="cc-name">Intestatario della carta</label>
                                <input type="text" className="form-control"
                                       value={this.state.intestatarioCarta}
                                       onChange={(e) => this.setState({intestatarioCarta: e.target.value})}
                                       required/>
                                    <small className="text-muted">Nome completo presente sulla carta</small>
                            </div>
                            <div className="col-md-6 mb-3">
                                <label htmlFor="cc-number">Numero della carta</label>
                                <input type="text" className="form-control"
                                       name="percentuale"
                                       value={this.state.numeroCarta}
                                       onChange={(e) => this.setState({numeroCarta: e.target.value})}
                                       required/>
                                    <div className="invalid-feedback">
                                        Credit card number is required
                                    </div>
                            </div>
                        <div className="row">
                            <div className="col-md-3 mb-3">
                                <label htmlFor="cc-expiration">Scadenza</label>
                                <input type="text" className="form-control"
                                       name="percentuale"
                                       value={this.state.scadenzaCarta}
                                       onChange={(e) => this.setState({scadenzaCarta: e.target.value})}
                                       required/>
                                    <div className="invalid-feedback">
                                        Expiration date required
                                    </div>
                            </div>
                            <div className="col-md-3 mb-3">
                                <label htmlFor="cc-expiration">CVV</label>
                                <input type="text" className="form-control"
                                       name="percentuale"
                                       value={this.state.cvvCarta}
                                       onChange={(e) => this.setState({cvvCarta: e.target.value})}
                                       required/>
                                    <div className="invalid-feedback">
                                        Security code required
                                    </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-4 order-md-2 mb-4">
                        <h4 className="d-flex justify-content-between align-items-center mb-3">
                            <span className="text-muted">Il tuo RUDCarrello</span>
                            <span className="badge badge-secondary badge-pill">{this.state.prodottiDaPagare.length}</span>
                        </h4>
                        <ul className="list-group mb-3">
                            <ProdottiDaPagare prodottiDaPagare={this.state.prodottiDaPagare}/>
                            <PagamentoTotale pagamentoTotale={this.state.pagamentoTotale}/>
                        </ul>

                        <form onSubmit={this.handleSubmit}>
                            <button className="btn btn-warning " type="submit">Paga</button>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div className="col-md-8 order-md-1">
                        <hr className="mb-4"/>
                        <h4 className="mb-3">Luogo di consegna</h4>
                        <div className="d-block my-3">
                            <div className="custom-control custom-radio">
                                <input id="indirizzo" name="luogoDiConsegna" type="radio" className="custom-control-input"
                                       checked={this.state.indirizzoChecked}
                                       onClick={(e) => this.setState(
                                           {
                                               indirizzoChecked: !this.state.indirizzoChecked,
                                               supermercatoChecked: false,
                                           }
                                       )} required/>
                                <label className="custom-control-label" htmlFor="indirizzo">Indirizzo</label>
                            </div>
                            <div className="custom-control custom-radio">
                                <input id="market" name="luogoDiConsegna" type="radio" className="custom-control-input"
                                       checked={this.state.supermercatoChecked}
                                       onClick={(e) => this.setState(
                                           {
                                               indirizzoChecked: false,
                                               supermercatoChecked: !this.state.supermercatoChecked,
                                           }
                                       )} required/>
                                <label className="custom-control-label" htmlFor="market">RUDMarket</label>
                            </div>
                            <form>
                                { !this.state.indirizzoChecked && !this.state.supermercatoChecked ? (
                                    <small className="text-muted">Scegliere una modalità di consegna</small>
                                    ) : this.state.indirizzoChecked ? (
                                    <div>
                                        <div className="mb-3">
                                            <label htmlFor="cc-name">Indirizzo</label>
                                            <input type="text"
                                                   className="form-control"
                                                   value={this.state.indirizzo}
                                                   onChange={(e) => {
                                                       this.setState({indirizzo: e.target.value})
                                                   }}
                                                   required/>
                                            <small className="text-muted">Indicare l'indirizzo per la consegna</small>
                                        </div>
                                    </div>
                                    ) : (
                                        <div className="container">
                                            <label htmlFor="cc-name">Supermercato</label>
                                            <div className="row">
                                                <select className="custom-select d-block w-100" value={this.state.selectedSupermercato}
                                                        onChange={
                                                            (e) => {
                                                                this.setState({selectedSupermercato: e.target.value})
                                                                this.setState({selectedMarker: this.state.markers[e.target.selectedIndex]})
                                                            }
                                                        }>
                                                    {this.state.supermercati.map((sup) => <option key={sup.value} value={sup.value}>{sup.display}</option>)}>
                                                </select>
                                            </div>
                                            <hr className="mb-4"/>
                                            <LoadScript //TODO there's a better way to do this
                                                id="script-loader"
                                                googleMapsApiKey = {GOOGLE_MAPS_API_KEY}
                                                //language={"italian"}
                                            >
                                                <GoogleMap
                                                    id='rud-map'
                                                    mapContainerStyle={{
                                                        height: "400px",
                                                        width: "640px",
                                                    }}
                                                    zoom={13}
                                                    center={{
                                                        lat: 45.0644956,
                                                        lng: 7.6741106
                                                    }}
                                                >

                                                    {
                                                        this.state.markers.map((marker) => (
                                                                <Marker
                                                                    icon={{url: "http://maps.google.com/mapfiles/ms/icons/yellow-dot.png"}}
                                                                    position={marker}
                                                                />
                                                            )
                                                        )
                                                    }

                                                    <Marker
                                                        icon={{url: "http://maps.google.com/mapfiles/ms/icons/green-dot.png"}}
                                                        position={this.state.selectedMarker}
                                                    />
                                                </GoogleMap>
                                            </LoadScript>
                                        </div>
                                    )
                                }
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </body>
        )
    }
}

export default Pagamento;