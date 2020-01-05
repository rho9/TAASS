import React from 'react'
import './Carrello.css'

const Ricette = ({ ricette, chiavi }) => {
    return(
        <tbody>
            {
                chiavi.map((chiave) => (
                    <section className="jumbotron text-center">
                        <h2>Ricette con {chiave}</h2>
                        <div className="table-responsive">
                            <table className="table table-striped table-sm">
                                <tbody>
                                {
                                    ricette[chiave].map((ricetta) => (
                                        <tr>
                                            <th>{ricetta.title}</th>
                                        </tr>
                                    ))
                                }
                                </tbody>
                            </table>
                        </div>
                    </section>
                ))
            }
        </tbody>
    );
};

export default Ricette