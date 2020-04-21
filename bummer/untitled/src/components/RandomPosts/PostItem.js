import React,{Component} from "react";

class PostItem extends Component {
    render() {
        const {post} = this.props;

        return (
            <div>
                <p>{post.title}</p>
            </div>
        );
    }
}

export default PostItem;