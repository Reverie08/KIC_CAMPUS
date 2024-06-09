<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.signup-container {
	background-color: white;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	width: 400px;
	padding: 20px;
}

.signup-container h2 {
	margin-top: 0;
	text-align: center;
	font-size: 24px;
}

.signup-container label {
	display: block;
	margin: 10px 0 5px;
	font-weight: bold;
}

.signup-container input[type="checkbox"] {
	margin-right: 10px;
}

.signup-container .checkbox-group {
	margin: 10px 0;
}

.signup-container .checkbox-group label {
	font-weight: normal;
}

.signup-container .checkbox-group p {
	margin: 0;
	padding-left: 25px;
}

.signup-container .checkbox-group p span {
	color: red;
}

.signup-container .details {
	border: 1px solid #ddd;
	padding: 10px;
	border-radius: 5px;
	background-color: #f9f9f9;
	margin-top: 10px;
	font-size: 14px;
	height: 100px;
	overflow-y: scroll;
}

.signup-container button {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

.signup-container button:disabled {
	background-color: #ccc;
}

.signup-container a {
	color: #007bff;
	text-decoration: none;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="signup-container">
		<form action="joinokPro" method="post" novalidate>
		<h2>회원가입</h2>
		<div class="checkbox-group">
			<label><input type="checkbox" id="allAgree"> 전체 동의</label>
		</div>
		<div class="checkbox-group">
			<label><input type="checkbox" class="subAgree" required>
				<span>개인정보 수집 및 이용 동의</span></label>
			<div class="details">
				<p>주식회사 두루는 “Greeting”을 통한 채용 절차 진행을 위하여 귀하의 정보를 수집합니다.</p>
				<p>
					<strong>수집하는 개인정보의 항목</strong><br> 성명, 전화번호, 이메일주소, 회사명(직책) 등
					채용 담당자의 정보
				</p>
				<p>
					<strong>개인정보처리의 목적</strong><br> 채용서비스를 위한 안내, 공지사항 전달, 채용 및
					회사와 이용 관련 연락 등의 개인정보처리를 목적으로 합니다.
				</p>
				<p>본 수집 및 이용 동의서는 개인정보보호법에 근거하여 작성되었습니다. 사용자의 개인정보는 최대한 보호되며,
					회사는 이를 엄격히 관리합니다. 추가적으로, 수집된 개인정보는 채용 절차가 완료된 후에도 일정 기간 동안 보관될 수
					있습니다. 개인정보의 보유 기간은 관련 법령에 따라 결정되며, 해당 기간이 종료된 후에는 즉시 폐기됩니다.</p>
				<p>귀하의 개인정보 제공은 채용 절차에 필수적이며, 동의를 거부할 권리가 있습니다. 다만, 동의하지 않을 경우
					채용 절차에 어려움이 있을 수 있습니다. 귀하는 언제든지 개인정보 제공에 대한 동의를 철회할 수 있으며, 이 경우 회사는
					지체 없이 수집된 개인정보를 파기합니다.</p>
				<p>회사는 개인정보 처리와 관련하여 이용자의 불만을 처리하기 위한 절차를 마련하고 있습니다. 개인정보와 관련된
					문의사항이나 불만 사항은 언제든지 개인정보 보호책임자에게 연락 주시기 바랍니다. 회사는 이용자의 소중한 개인정보를
					안전하게 보호하기 위해 최선을 다할 것입니다.</p>
			</div>
		</div>
		<div class="checkbox-group">
			<label><input type="checkbox" class="subAgree" required>
				<span>이용약관 동의</span></label> <a href="#">자세히 보기</a>
		</div>
		<button type="submit" id="submitBtn" disabled>계속</button>
		</form>
	</div>

	<script>
        document.getElementById('allAgree').addEventListener('change', function() {
            let checkboxes = document.querySelectorAll('.subAgree');
            for (let checkbox of checkboxes) {
                checkbox.checked = this.checked;
            }
            toggleSubmitButton();
        });

        let subAgreeCheckboxes = document.querySelectorAll('.subAgree');
        for (let checkbox of subAgreeCheckboxes) {
            checkbox.addEventListener('change', function() {
                if (!this.checked) {
                    document.getElementById('allAgree').checked = false;
                }
                toggleSubmitButton();
            });
        }

        function toggleSubmitButton() {
            let allChecked = true;
            for (let checkbox of subAgreeCheckboxes) {
                if (!checkbox.checked) {
                    allChecked = false;
                    break;
                }
            }
            document.getElementById('submitBtn').disabled = !allChecked;
        }
    </script>
</body>
</html>
