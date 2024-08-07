import { useState } from "react";
import { useNavigate } from 'react-router-dom';


function BoardForm() {

  const navigate = useNavigate()


  const [gname, setGname] = useState("");
  const [pass, setPass] = useState("");
  //const [pass2, setPass2] = useState("");
  const [subject, setSubject] = useState("");
  const [content, setContent] = useState("");
  const [file2, setFile2] = useState("");


  const clearForm = () => {

    setGname("");
    setPass("");
    //setPass2("");
    setSubject("");
    setContent("");
    setFile2("");
    // setRegdate("");
    // setReadcnt("")

  };
  // clearForm()
  const handleSubmit = (e) => {
    e.preventDefault();
    let fileinput = document.querySelector("#file2")
    // alert("submit")
    try {
      const form = new FormData()

      form.append('name', gname)
      form.append('pass', pass)
      form.append('subject', subject)
      form.append('content', content)

      form.append('file2', fileinput.files[0])


      // alert(form)
      fetch('http://localhost:8080/board/boardPro', {
        method: 'POST',
        body: form,
      })

      navigate("/board/boardList?boardid=1&pageNum=1");//send redirect와 같은 느낌
    } catch (e) {
      console.log(e)
    }



  }

  return (

    <div className="container">
      <h4 className="text-center">게시판 입력</h4>
      <form className="container" method="post" enctype="multipart/form-data" onSubmit={handleSubmit} >
        <div className="form-group">
          <label for="name">작성자:</label>
          <input type="text" className="form-control" placeholder="Enter name" id="name"
            onChange={(e) => {
              setGname(e.target.value);
            }}
            value={gname}
            name="name" />
        </div>
        <div className="form-group">
          <label for="pwd">비밀번호:</label>
          <input type="password" className="form-control" placeholder="Enter password" id="pwd"
            onChange={(e) => {
              setPass(e.target.value);
            }}
            value={pass}
            name="pass" />
        </div>
        <div className="form-group">
          <label for="subject">제목:</label>
          <input type="text" className="form-control" placeholder="Enter password" id="subject"
            onChange={(e) => {
              setSubject(e.target.value);
            }}
            value={subject}
            name="subject" />
        </div>

        <div className="form-group">
          <label for="content">내용:</label>
          <textarea className="form-control" rows="5" id="content"
            onChange={(e) => {
              setContent(e.target.value);
            }}
            value={content}
            name="content"></textarea>
        </div>
        <div className="form-group">
          <label for="file">파일:</label>
          <input type="file" className="form-control" id="file2"
            onChange={(e) => {
              setFile2(e.target.value);
            }}
            value={file2}

            name="file2" />
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>

  )
}

export default BoardForm




