//import axios from "axios";  
//fetch와 함께 쓰면 에러난다
//<td>{boardCount-(pageInt-1)*3 - index}</td> page num 내림차순 프린트 한다 
//입력 되어 있는 자료이면 계산이 된다 



import { useState, useEffect } from "react";

import { useLocation } from 'react-router-dom';
import dayjs from 'dayjs'  //날자 포멧 lib

const BoardList = () => {
  //const query = window.location.search
  //?boardid=1
  //{min(rt.start,rt.bottomLine)}
  // 자꾸 map에 관한 에러가 난다 
  //console.log(query)
  const [bList, setBList] = useState([]);
  const [boardCount, setBoardCount] = useState([]);
  const [start, setStart] = useState([]);
  const [end, setEnd] = useState([]);
  const [pageInt, setPageInt] = useState([]);
  const [bottomLine, setBottomLine] = useState([]);
  const [maxPage, setMaxPage] = useState([]);
  const [boardName, setBoardName] = useState([]);

  // 렌더링 되고 한번만 전체 게시물 갯수 가져와서 페이지 카운트 구하기
  // 렌더링 되고 한번만 페이지에 해당하는 게시물 가져오기
  const location = useLocation();
  let queryString = location.search;

  //  console.log(queryString.length)
  //  console.log(typeof(queryString))

  useEffect(() => {
    getBoardList();
  }, []);

  const getBoardList = () => {
    if (queryString.length === 0) { queryString = "?boardid=1"; }


    // fetch는 동기화 작업을 한다    async생락한다 
    fetch("http://localhost:5000/board/restlist/" + queryString)
      .then((resp) => resp.json())
      .then((json) => {
        console.log(json)
        let jsonblist = JSON.parse(json.blist)

        setBList(jsonblist);

        setBoardCount(json.totalcount);
        setStart(json.startpage);
        setEnd(json.endpage);
        setPageInt(json.pageNum);
        setBottomLine(json.bottomLine);
        setMaxPage(json.maxpage);
        setBoardName("게시판")

      })

  }








  function getPage(start, end) {

    let arr = []
    for (let i = start; i <= end; i++) {
      arr.push(i)

    }

    console.log(arr)
    return arr
  }
  function getActive(p) {
    console.log(pageInt, p)
    if (pageInt == p) {
      return "active"
    } else {
      return null
    }
  }

  return (
    <div>
      <div className="container">
        <h2 className="text-center">{boardName}[{boardCount}]</h2>
        <p className="text-right">	<a className="btn btn-primary" href="boardForm">게시판입력</a></p>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>번호</th>
              <th>작성자</th>
              <th>제목</th>
              <th>날자</th>
              <th>조회수</th>
              <th>파일</th>
            </tr>
          </thead>
          <tbody>

            {bList.map((b, index) => (

              <tr>
                <td>{boardCount - (pageInt - 1) * 3 - index}</td>

                <td>{b.fields.name} </td>
                <td><a href={"boardInfo?num=" + b.fields.num}     >{b.fields.subject} </a></td>
                <td>{dayjs(b.fields.regdate).format('YYYY-MM-DD')} </td>
                <td>{b.fields.readcnt} </td>
                <td> <img src={"http://localhost:8080/webapp/img/board/" + b.fields.file1} width="30px" /></td>


              </tr>

            ))}


          </tbody>
        </table>






        <ul className="pagination  center" style={{ justifyContent: "center" }} >
          <li className={start <= bottomLine ? "page-item disabled" : "page-item "}        >
            <a className="page-link" href={"/board/boardList?pageNum=" + (start - bottomLine)}>Previous</a></li>

          {getPage(start, end).map((p) => (
            <li className={pageInt == p ? "page-item active" : "page-item"}>
              <a className="page-link" href={"/board/boardList?pageNum=" + p}>{p}</a></li>
          ))}





          <li className={end >= maxPage ? "page-item disabled" : "page-item "} >
            <a className="page-link" href={"/board/boardList?pageNum=" + (start + bottomLine)}>Next</a></li>
        </ul>

      </div>
    </div>
  )


}
export default BoardList

