
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';




const Login = () => {
  const navigate = useNavigate()  //redirect
  const [id, setId] = useState("");
  const [pass, setPass] = useState("");

  const clearForm = () => {
    setId("");
    setPass("");
  };

  const handleSubmit = (e) => {

    e.preventDefault();

    //alert("submit")
    try {
      const form = new FormData()
      form.append('id', id)
      form.append('pass', pass)
      //alert(form)
      fetch('http://localhost:8080/member/loginPro', {
        body: form,  //로그인 자료 입력
        method: 'POST', //form 전송방식 
        // 8080에서 보낸 쿠키 자료 받는다 
        mode: 'cors',
        xhrFields: {
          withCredentials: true
        },
        credentials: 'include',
        crossDomain: true,

      })
        .then((res) => res.json())
        .then((json) => {
          alert(JSON.stringify(json))
          if (json.token === "1") {
            navigate("/board/boardList");
          } else {
            navigate("/member/login");
          }

        }
        )

    } catch (e) {
      // 서버에서 받은 에러 메시지 출력
      toast.error("오류발생!", { position: "top-center", });
    }

    clearForm();

  }






  return (
    <div >
      <div className="container">
        <div className="input-form-backgroud row">
          <div className="input-form col-md-12 mx-auto">
            <h4 className="mb-3  center">로그인</h4>
            <form className="validation-form" novalidate onSubmit={handleSubmit} method="post" >

              <div className="row">
                <div className="col-md-6 mb-3">
                  <label for="id">아이디</label> <input type="text"
                    className="form-control" id="id"
                    onChange={(e) => {
                      setId(e.target.value);
                    }}
                    value={id}

                    required name="id" />
                  <div className="invalid-feedback">아이디를 입력해주세요.</div>
                </div>
                <div className="col-md-6 mb-3">
                  <label for="pass">비밀번호</label> <input type="password"
                    className="form-control" id="pass"
                    onChange={(e) => {
                      setPass(e.target.value);
                    }}
                    value={pass}
                    name="pass"
                    required />
                  <div className="invalid-feedback">비밀번호을 입력해주세요.</div>
                </div>
              </div>


              <div className="mb-4"></div>
              <button className="btn btn-primary btn-lg btn-block" type="submit">로그인</button>
            </form>
          </div>
        </div>




      </div>

    </div>

  )








}

export default Login;
