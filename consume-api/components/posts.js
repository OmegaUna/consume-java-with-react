import Head from 'next/head'
import { useState, useEffect } from 'react';
import Card from './card'
export default function Posts() {
  const [posts, setPosts] = useState([]);
  useEffect(() => {
    //fetch('localhost:5001/api/posts')
    fetch('https://localhost:8080/posts')
    .then((res) => res.json())
    .then((data) => {
      setPosts(data);
    })
    .catch((err) => {
      console.log(err);
    })
  }, []);
  return (
    <div className="container">
      <section>
        {posts.map((post) => <Card key={post.id} post={post}/>)}
      </section>

      <style jsx>{`

      `}</style>
    </div>
  )
}
