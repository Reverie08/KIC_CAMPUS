import { useState, useEffect } from "react";
import { useLocation } from 'react-router-dom';
//import Comment from "./Comment";
//1.className=  className=  수정한다
//2.json으로 받아야하는 변수를 설정한다 
//{"count":0,
//"board":{"num":5,"name":"fdfd","pass":"dfdf","subject":"dfdf","content":"dfdf",
//"file1":"스크린샷 2024-04-18 171224.png","regdate":"2024-04-23T08:37:42.000+00:00","readcnt":0,"boardid":"1"},
//"commentLi":[]}
//3. onclick ---> onClick으로 수정한다
//onkeyup ---> onKeyUp으로 수정한다
//4.  역순프린트 :  {commentLi.map((b, index)=>(  이용하여 commentLi.length - index를 한다
//5. 입력후에 입력 value blank    enterkey(e, board.num); setComment("");}
//6. router href={"boardInfo?num="+b.num}
function BoardInfo() {

  // javascript 위치임 
  let [count, setCount] = useState([]);
  const [board, setBoard] = useState([]);
  const [li, setLi] = useState([]);
  const [comment, setComment] = useState([]);
  //const [content, setContent] = useState([])

  function CommentDes(props) {   //component
    return (
      <div className="row" >
        <div className="col-sm-1" >&nbsp;</div>
        <div className="col-sm-1">{props.index}</div>
        <div className="col-sm-9">{props.content} </div>
        <div className="col-sm-1">&nbsp;</div>
      </div>
    )
  }

  function enterkey(e, num, count) {
    if (e.keyCode === 13) {
      commentPro(num, count)
      setComment("");

    }

  }
  function commentPro(num, count) {
    console.log(num, count)

    //let comment = document.querySelector("#comment").value
    //alert(comment)
    //login이랑 상관없이 all id로 입력 함
    const xhttp = new XMLHttpRequest()
    let url = "http://localhost:8080/board/boardCommentPro?comment=" + comment + "&boardnum=" + num + "&count=" + count
    console.log(url)

    fetch(url)
      .then((resp) => resp.json())
      .then((json) => {
        let commentList = document.querySelector("#commentNew")
        const temp = '<div class="row" >'
          + '<div class="col-sm-1">&nbsp;</div>'
          + '<div class="col-sm-1">' + json.count + '</div>'
          + '<div class="col-sm-9">' + json.comment + ' </div>'
          + '<div class="col-sm-1">&nbsp;</div></div>'
        setCount(json.count)

        console.log(temp)
        commentList.innerHTML = temp + commentList.innerHTML

      })




  }





  const location = useLocation();


  const getBoardInfo = () => {
    // fetch는 동기화 작업을 한다    async생락한다 

    const queryString = location.search;
    console.log(queryString)
    fetch("http://localhost:8080/board/boardInfo" + queryString)
      .then((resp) => resp.json())
      .then((json) => {
        console.log(json)
        //    alert("ok")
        setCount(json.count);  //comment를 읽어서 현재 count를 return 한다
        setBoard(json.board);
        setLi(json.li);


      })

  }

  useEffect(() => {
    getBoardInfo();
  }, []);


  return (


    <div>
      <div className="container">
        <div className="input-form-backgroud row">
          <div className="input-form col-md-12 mx-auto">
            <h4 className="mb-3">게시판</h4>
            <table className="table">

              <tr>
                <td>파일</td>
                <td>{board.file1}<img src={"http://localhost:8080/webapp/img/board/" + board.file1}
                  width="100px" height="120px" /></td>
              </tr>
              <tr>
                <td>제목</td>
                <td>{board.subject}</td>
              </tr>
              <tr>
                <td>내용</td>
                <td>{board.content}</td>
              </tr>
              <tr>
                <td>날자</td>
                <td>{board.regdate}</td>
              </tr>
              <tr>
                <td>조회수</td>
                <td>{board.readcnt}</td>
              </tr>
              <tr>
                <td colspan="2" className="text-right"><a className="btn btn-primary"
                  href={"/board/boardUpdateForm?num=" + board.num}>변경</a>
                  <a className="btn btn-primary"
                    href={"/board/boardDeleteForm?num=" + board.num}>삭제</a>
                  <a className="btn btn-primary"
                    href={"/board/boardList"}>목록</a>
                </td>
              </tr>
            </table>

            <div className="row">
              <div className="col-sm-1">답변글</div>
              <div className="col-sm-10">
                <input type="text" className="form-control " id="comment"
                  onChange={(e) => { setComment(e.target.value); }}
                  value={comment}
                  onKeyUp={(e) => { enterkey(e, board.num, count + 1); }} />
              </div>
              <div className="col-sm-1">
                <button className="btn btn-primary "
                  onClick={(e) => { commentPro(board.num, count + 1); setComment(""); }}   > 저장</button>
              </div>
            </div>
            <div id="commentNew"></div>
            <div id="commentList">
              {li.length > 0 ? (
                li.map((b, index) => (
                  <CommentDes index={li.length - index} content={b.content} />
                ))
              ) : (
                <p>No items available</p>
              )}





            </div>
          </div>
        </div>

      </div>
    </div>

  )

}

export default BoardInfo