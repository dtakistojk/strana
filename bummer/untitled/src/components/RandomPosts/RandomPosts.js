import React, {Component} from "react";
import "./RandomPost.css";
import {connect} from "react-redux";
import {getPosts} from "../../actions/postActions";
import PropTypes from "prop-types";
import PostItem from "./PostItem";


class RandomPosts extends Component {

    componentDidMount() {
        this.props.getPosts();
    }

    render() {

        const {posts} = this.props.post;
        let counter = 5;
        return (
            <div className="row">
                <div className="col-12">
                    <div className="first-section">
                        {posts.map(post =>(
                                <div className={`itemA${counter--}`}
                                     style={{backgroundImage:`url(${post.image})`}}
                                     key={post.id} post={post}>
                                    <h3 className="text-white">{post.title}</h3>
                                </div>
                            ))
                        }
                    </div>
                </div>
            </div>
        );
    }
}

RandomPosts.propTypes = {
    post: PropTypes.object.isRequired,
    getPosts: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
    post:state.post
});


export default connect(mapStateToProps,{getPosts}) (RandomPosts);