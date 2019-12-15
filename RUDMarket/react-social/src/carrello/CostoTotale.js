import React from 'react'
import './Carrello.css'

const CostoTotale = ({ costoTotale }) => {
    return(
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th>Totale {costoTotale.toString()}</th>
            </tr>
    );
};

export default CostoTotale