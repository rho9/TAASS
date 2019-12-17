import React from 'react'
import './Pagamento.css'

const PagamentoTotale = ({ pagamentoTotale }) => {
    return(
        <li className="list-group-item d-flex justify-content-between">
            <span>Totale</span>
            <strong>{pagamentoTotale}€</strong>
        </li>
    );
};

export default PagamentoTotale