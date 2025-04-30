var checkCodeKey = null;
var isLogined = 0;
const baseURL = 'http://localhost:7071/web';

function setCookie(name, value, days) {
    const date = new Date();
    date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
    const expires = "; expires=" + date.toUTCString();
    document.cookie = `${name}=${value}${expires}; path=/`;
}

function getCookie(name) {
    const cookieArr = document.cookie.split("; ");
    for (const cookie of cookieArr) {
        const [key, value] = cookie.split("=");
        if (key === name) return decodeURIComponent(value);
    }
    return null;
}

function reloadCaptcha() {
    axios.get('http://localhost:7071/web/account/checkCode')
       .then(response => {
            const captchaImg = document.getElementById('captchaRegister');
            captchaImg.src = response.data.data.checkCode;
            checkCodeKey = response.data.data.checkCodeKey;
            console.log(checkCodeKey);
        })
       .catch(error => {
            console.error('获取注册验证码失败:', error);
        });
}

function openLoginModal() {
    document.getElementById('loginModal').style.display = 'block';
    axios.get('http://localhost:7071/web/account/checkCode')
       .then(response => {
            const captchaImg = document.getElementById('captchaLogin');
            captchaImg.src = response.data.data.checkCode;
            checkCodeKey = response.data.data.checkCodeKey;
            console.log(checkCodeKey);
        })
       .catch(error => {
            console.error('获取登录验证码失败:', error);
        });
}

function closeLoginModal() {
    document.getElementById('loginModal').style.display = 'none';
}

function openRegisterModal() {
    document.getElementById('registerModal').style.display = 'block';
    axios.get('http://localhost:7071/web/account/checkCode')
       .then(response => {
            const captchaImg = document.getElementById('captchaRegister');
            captchaImg.src = response.data.data.checkCode;
            checkCodeKey = response.data.data.checkCodeKey;
            console.log(checkCodeKey);
        })
       .catch(error => {
            console.error('获取注册验证码失败:', error);
        });
}

function closeRegisterModal() {
    document.getElementById('registerModal').style.display = 'none';
}

function closeModalOutside(event) {
    const loginModal = document.getElementById('loginModal');
    const registerModal = document.getElementById('registerModal');
    if (event.target === loginModal) {
        closeLoginModal();
    } else if (event.target === registerModal) {
        closeRegisterModal();
    }
}

document.getElementById('registerButton').addEventListener('click', async () => {
    const email = document.getElementById('registerEmail').value;
    const nickName = document.getElementById('registerNickName').value;
    const registerPassword = document.getElementById('registerPassword').value;
    const checkCode = document.getElementById('registerCaptcha').value;
    const registerCheckCodeKey = checkCodeKey;

    try {
        axios.post(`${baseURL}/account/register?email=` + email + '&nickName=' + nickName + '&registerPassword=' + registerPassword + '&checkCode=' + checkCode + '&checkCodeKey=' + registerCheckCodeKey)
           .then(response => {
                alert('注册成功');
                autoLogin();
                closeRegisterModal();
            })
           .catch(error => {
                console.error('请求失败:', error);
            });
    } catch (error) {
        console.error('注册失败:', error);
        reloadCaptcha();
    }
});

document.getElementById('loginButton').addEventListener('click', async () => {
    const email = document.getElementById('loginEmail').value;
    const loginPassword = document.getElementById('loginPassword').value;
    const checkCode = document.getElementById('loginCaptcha').value;
    const loginCheckCodeKey = checkCodeKey;
    console.log(email, loginPassword, checkCode, loginCheckCodeKey)
    try {
        axios.post(`${baseURL}/account/login?email=` + email + '&password=' + loginPassword + '&checkCode=' + checkCode + '&checkCodeKey=' + loginCheckCodeKey)
           .then(response => {
                const responseInfo = response.data.info;
                alert(`${responseInfo}`); // 显示登录成功信息
                if (response.data.info === '图片验证码错误') {
                    axios.get('http://localhost:7071/web/account/checkCode')
                       .then(response => {
                            const captchaImg = document.getElementById('captchaLogin');
                            captchaImg.src = response.data.data.checkCode;
                            checkCodeKey = response.data.data.checkCodeKey;
                            console.log(checkCodeKey);
                        })
                       .catch(error => {
                            console.error('获取登录验证码失败:', error);
                        });
                }
                setCookie('token', response.data.data.token, 7);
                setCookie('userId', response.data.data.userId, 7);
                setCookie('nickName', response.data.data.nickName, 7);
                setCookie('sex', response.data.data.sex, 7);
                setCookie('birthday', response.data.data.birthDay, 7);
                setCookie('personIntroduction', response.data.data.personIntroduction, 7);
                setCookie('avatar', response.data.data.avatar, 7);


                console.log(getCookie('token'));
                const avatar = getCookie('avatar');
                const token = getCookie('token');
                if (token) {
                    topLoginBtn.style.display = 'none';
                    topRegisterBtn.style.display = 'none';
                    avatarDropdown.style.display = 'block';
                    userAvatar.src = avatar || 'https://picsum.photos/40/40';
                }
                autoLogin();
                closeLoginModal();
            })
           .catch(error => {
                console.log(`${baseURL}/account/account/login?email=` + email + '&password=' + loginPassword + '&checkCode=' + checkCode + '&checkCodeKey=' + loginCheckCodeKey)
                console.error('请求失败:', error);
            });
    } catch (error) {
        console.error('登录失败:', error);
        axios.get('http://localhost:7071/web/account/checkCode')
           .then(response => {
                const captchaImg = document.getElementById('captchaLogin');
                captchaImg.src = response.data.data.checkCode;
                checkCodeKey = response.data.data.checkCodeKey;
                console.log(checkCodeKey);
            })
           .catch(error => {
                console.error('获取注册验证码失败:', error);
            });
    }
});

window.onload = function () {
    autoLogin();
    loadForumList();
}

function autoLogin() {
    const token = getCookie('token');
    console.log(token);
    if (token) {
        axios.get(`${baseURL}/account/loginCheck`, {
            headers: {
                'token': token
            }
        }).then(response => {
            if (response.data.code === 200) {
                console.log(response.data.data);
                isLogined = response.data.data;
                if (isLogined) {
                    console.log(document.getElementById('topLoginBtn'));
                    document.getElementById('topLoginBtn').style.display = 'none';
                    document.getElementById('topRegisterBtn').style.display = 'none';

                    
                }
            }
        })
    }
}    