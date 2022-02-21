import Head from 'next/head'
import dynamic from 'next/dynamic'
import { Box, Container } from '@chakra-ui/react'


const Main = ({ children, router }) => {
  return (
    <Box as="main" pb={8}>
      <Head>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Dazzy's homepage" />
        <meta name="author" content="Dazzy Kyei" />
        <meta name="author" content="omegamaxy" />
        <link rel="apple-touch-icon" href="https://omegatoday.eu/app/img/ou/OmegaUnaIcon.ico" />
        <link rel="shortcut icon" href="https://omegatoday.eu/app/img/ou/OmegaUnaIcon.ico" />
        <meta property="og:site_name" content="Dazzy Kyei's Homepage" />
        <meta property="og:type" content="website" />
        <meta property="og:image" content="/card.png" />
        <title>Dazzy Kyei - Homepage</title>
      </Head>

      <Container maxW="container.md" pt={14}>


        {children}

      </Container>
    </Box>
  )
}

export default Main
