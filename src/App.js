import './App.css';
import React from "react";
import { useCookies } from 'react-cookie';
import { Routes, Route } from "react-router-dom";
//npm install react-cookies --save
import Head from "./components/Head";
import BoardList from "./components/board/BoardList";
import BoardForm from './components/board/BoardForm';
import BoardInfo from './components/board/BoardInfo';
import Login from './components/member/Login';

//npm install react-cookies --save
function App() {
  const [cookies] = useCookies(['id']);
  //cookies.id

  const id = cookies.id
  //alert(cookies.id+"  app "+id)
  return (
    <React.Fragment>
      <Head cook={cookies.id} />
      <Routes>
        <Route path="/board/boardList" element={<BoardList />} />
        <Route path="/board/boardForm" element={<BoardForm />} />
        <Route path="/board/boardInfo" element={<BoardInfo />} />
        <Route path="/member/login" element={<Login />} />
      </Routes>
    </React.Fragment>

  );
}

export default App;

