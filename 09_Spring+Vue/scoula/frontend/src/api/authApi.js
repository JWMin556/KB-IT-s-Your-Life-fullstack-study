import api from '@/api'; // 인터셉터가 적용된 axios가 바로 우리가 직접 커스터마이징한 것

const BASE_URL = '/api/member';
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
  // username 중복 체크, true: 중복(사용불가), false: 사용 가능
  async checkUsername(username) {
    // 기본적으로 js는 비동기이다. 그런데 강제로 동기로 해주기 위해서 async, await로 하는게 좋다.

    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`); // await는 promise를 리턴하는 비동기 함수에만 붙일 수 있다.
    console.log('AUTH GET CHECKUSERNAME', data);
    return data;
  },

  async create(member) {
    // 아바타 파일 업로드 – multipart 인코딩 필요 -> FormData 객체 사용 (html의 form을 캡슐화한 객체)

    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password);

    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    const { data } = await api.post(BASE_URL, formData, headers); // MemberDTO의 내용이 data안에 들어감

    console.log('AUTH POST: ', data);
    return data;
  },

  async update(member) {
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('password', member.password);
    formData.append('email', member.email);

    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    const { data } = await api.put(
      `${BASE_URL}/${member.username}`,
      formData,
      headers
    );
    console.log('AUTH PUT: ', data);
    return data;
  },

  async changePassword(formData) {
    const { data } = await api.put(
      `${BASE_URL}/${formData.username}/changepassword`,
      formData
    );
    console.log('AUTH PUT: ', data);

    return data;
  },
};
