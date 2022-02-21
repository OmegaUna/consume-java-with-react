import Head from 'next/head'
import Posts from '../components/posts'
import { Heading } from '@chakra-ui/react'
export default function Home() {
  return (
    <div className="container">
      <Head>
        <title>Consume API</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main>
        <Heading>Posts</Heading>
        <section>
          <Posts/>
        </section>
      </main>

      <style jsx>{`

      `}</style>

      <style jsx global>{`
        html,
        body {
          padding: 0;
          margin: 0;
          font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto,
            Oxygen, Ubuntu, Cantarell, Fira Sans, Droid Sans, Helvetica Neue,
            sans-serif;
        }

        * {
          box-sizing: border-box;
        }
      `}</style>
    </div>
  )
}
