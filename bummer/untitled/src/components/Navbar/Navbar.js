import React,{Component} from "react";
import "./Navbar.css";

class Navbar extends Component {
    render() {
        return (
                <div className="header">
                    <div className="row main-menu">
                        <div className="navigation blue circleBehind">
                            <a href="/home">HOME</a>
                            <a href="/articles">ARTICLES</a>
                            <a href="/portfolio">PORTFOLIO</a>
                            <a href="about">ABOUT</a>
                            <a href="contact">CONTACT</a>
                        </div>
                    </div>
                </div>
        );
    }
}

export default Navbar;