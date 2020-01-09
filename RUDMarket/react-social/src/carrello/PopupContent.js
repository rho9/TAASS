import React, {Component} from "react";
import './Carrello.css'

class PopupContent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ricette: [],
        };

        fetch('https://spring-efp.herokuapp.com/recipeFromIngredient/' + this.props.titoloRicetta)
            .then(res => res.json())
            .then((data) => {
                this.setState({ricette: data})
            })
    }

    render() {
        return(
            <div>
                <a onClick={this.props.close}>
                    &times;
                </a>
                <h2 align="center">Ricette con {this.props.titoloRicetta}</h2>
                <section className="jumbotron text-center">
                    <div className="table-responsive">
                        <div className="table-responsive">
                            <table className="table table-striped table-sm">
                                <tbody>

                                {
                                    this.state.ricette.length > 0 ? (
                                        this.state.ricette.map((ricetta) => (
                                            <tr>
                                                <th>{ricetta.title}</th>
                                            </tr>
                                        ))
                                    ) : (
                                        <tr>
                                            <th>Nessuna Ricetta Disponibile</th>
                                        </tr>
                                    )
                                }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
            </div>
        )
    }
}

export default PopupContent;