import React, {Component} from 'react'
import './Catalogo.css'
import {Link} from "react-router-dom";


class ImmagineProdotto extends Component {
    constructor(props) {
        super(props);
        this.state = {
            immagine: ''
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/prodotto/getImageProdottoByProdottoId', {
            method: 'POST',
            body: this.props.prodottoId
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
            <ul className="list-unstyled mt-3 mb-4">
                <img src={this.state.immagine} width="100px" height="100px" />
            </ul>
        )
    }
}

export default ImmagineProdotto