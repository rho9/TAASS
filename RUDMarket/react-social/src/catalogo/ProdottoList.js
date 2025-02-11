import React, {Component} from 'react'
import './Catalogo.css'
import {Link, Redirect} from "react-router-dom";
import ImmagineProdotto from "./ImmagineProdotto";


class ProdottoList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            immagine: '',
            prodotti: this.props.prodotti
        }
    }

    componentWillMount() {
        this.setState({prodotti: this.props.prodotti})
    }

    render() {
        return (
            this.state.prodotti ? (
                <div className="row">
                    {this.state.prodotti.map((prodotto) => (
                        <div className="card mb-4 box-shadow">
                            <div className="card-header">
                                <h4 className="my-0 font-weight-normal">{prodotto.nome}</h4>
                            </div>
                            <div className="card-body">
                                <h1 className="card-title pricing-card-title">€{prodotto.prezzo} {
                                    prodotto.atKg ? (
                                        <small className="text-muted">/ kg</small>
                                    ) : (
                                        <small className="text-muted"></small>
                                    )
                                } </h1>
                                <ul className="list-unstyled mt-3 mb-4">
                                    <li>{prodotto.marca}</li>
                                </ul>
                                <ImmagineProdotto prodottoId={prodotto.id}/>
                                <Link className="btn btn-warning" to={
                                    {
                                        pathname: "/addCarrello",
                                        idProdotto: prodotto.id,
                                        nomeProdotto: prodotto.nome,
                                        atKg: prodotto.atKg
                                    }
                                }>Aggiungi al Carrello</Link>
                            </div>
                        </div>
                    ))}
                </div>
            ) : (
                <div className="row">
                    Qualcosa è andato storto durante il caricamento della pagina, probabilmente perchè hai ricaricato la pagina. Ti consigliamo di utilizzare i pulsanti di navigazione del sito!
                </div>
            )
        )
    }
}

export default ProdottoList