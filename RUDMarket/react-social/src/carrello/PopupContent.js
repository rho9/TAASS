import React, {Component} from "react";
import './Carrello.css'


export default ({ close, parametro }) => (
    <div>
        <a onClick={close}>
            &times;
        </a>
        <h2 align="center">Ricette con {parametro} </h2>
        <section className="jumbotron text-center">
            <div className="table-responsive">
                <div className="table-responsive">
                    <table className="table table-striped table-sm">
                        <tbody>
                            <tr>
                                <th>Ciao</th>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>
);