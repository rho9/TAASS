import React, {Component} from 'react'
import './Carrello.css'
import PopupContent from "./PopupContent";
import Popup from "reactjs-popup";

class ProdottiInCarrello extends Component {
    constructor(props) {
        super(props);
        this.state = {

        };
    }

    render() {
        return (
            <tbody>
            {this.props.prodottiInCarrello.map((prodottoInCarrello) => (
                <tr>
                    <th>{prodottoInCarrello.quantita}</th>
                    <th>{prodottoInCarrello.prodotto.nome}</th>
                    <th>{prodottoInCarrello.prodotto.marca}</th>
                    {
                        prodottoInCarrello.percSconto == 0 ? (
                            <th>{prodottoInCarrello.prodotto.prezzo}</th>
                        ) : (
                            <th>{prodottoInCarrello.prodotto.prezzo} (-{prodottoInCarrello.percSconto}%)</th>
                        )
                    }
                    <th>{(prodottoInCarrello.prodotto.prezzo - ((prodottoInCarrello.prodotto.prezzo * prodottoInCarrello.percSconto) / 100)) * prodottoInCarrello.quantita}</th>
                    <th>
                        <Popup modal trigger={<button className="btn btn-warning">Ricette con questo prodotto</button>}>
                            {close => <PopupContent close={close} titoloRicetta={prodottoInCarrello.prodotto.nome} />}
                        </Popup>
                    </th>
                </tr>
            ))}
            </tbody>
        )
    }
}
/*const ProdottiInCarrello = ({ prodottiInCarrello }) => {
    return(
        <tbody>
            {prodottiInCarrello.map((prodottoInCarrello) => (
                <tr>
                    <th>{prodottoInCarrello.quantita}</th>
                    <th>{prodottoInCarrello.prodotto.nome}</th>
                    <th>{prodottoInCarrello.prodotto.marca}</th>
                    {
                        prodottoInCarrello.percSconto == 0 ? (
                            <th>{prodottoInCarrello.prodotto.prezzo}</th>
                        ) : (
                            <th>{prodottoInCarrello.prodotto.prezzo} (-{prodottoInCarrello.percSconto}%)</th>
                        )
                    }
                    <th>{(prodottoInCarrello.prodotto.prezzo - ((prodottoInCarrello.prodotto.prezzo * prodottoInCarrello.percSconto) / 100)) * prodottoInCarrello.quantita}</th>
                    <th>
                        <Popup modal trigger={<button className="btn btn-warning">Ricette con questo prodotto</button>}>
                        {close => <PopupContent close={close} titoloRicetta={prodottoInCarrello.prodotto.nome} ricette={ric[prodottoInCarrello.prodotto.nome]} />}
                        </Popup>
                    </th>
                </tr>
            ))}
        </tbody>
    );
};*/

export default ProdottiInCarrello;