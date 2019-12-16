import React from 'react'
import './Pagamento.css'

const PagamentoTotale = ({ pagamentoTotale }) => {
    return(
        <li className="list-group-item d-flex justify-content-between">
            <span>Total (USD)</span>
            <strong>{pagamentoTotale.toString()}</strong>
        </li>
    );
};

export default PagamentoTotale