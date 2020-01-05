import React, {Component} from 'react'
import './Catalogo.css'
import {Link} from "react-router-dom";
import ImmagineProdotto from "./ImmagineProdotto";
import {API_BASE_URL} from "../constants";


class ProdottoList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            immagine: ''
        }
    }

    componentDidMount() {
        fetch(API_BASE_URL + '/prodotto/getImageProdottoByProdottoId', {
            method: 'POST',
            body: 3
        })
            .then(response => response.blob())
            .then((data) => {
                let reader = new FileReader();
                reader.readAsDataURL(data);
                reader.onload = (e) => {
                    this.setState({immagine: e.target.result})
                };
            })
    }

    render() {
        return (
            <div className="row">
                {this.props.prodotti.map((prodotto) => (
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
        )
    }
}

export default ProdottoList