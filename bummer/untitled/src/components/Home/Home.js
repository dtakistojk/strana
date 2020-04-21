import React,{ Component } from "react";
import Navbar from "../Navbar/Navbar";
import Footer from "../Footer/Footer";
import RandomPosts from "../RandomPosts/RandomPosts";

class Home extends Component {
    render() {
        return (<div>
            <Navbar />
            <div className="container">
                <RandomPosts/>
            </div>
        </div>
        );
    }
}

export default Home;