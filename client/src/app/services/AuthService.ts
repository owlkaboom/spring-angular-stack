import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  loggedInUser?: string;

  constructor(private http: HttpClient) {}

  async login(username: string, password: string) {
    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);

    try {
      await this.http
        .post(`${environment.apiServerUrl}/auth`, formData, {
          withCredentials: true,
        })
        .toPromise();
      // TODO: how to know what the actual response code is?
      // do we just assume 200 if we get here??? no idea
      const user = await this.getUser();
      this.loggedInUser = user?.username;
      return true;
    } catch (error) {
      console.log('hit error', error);
    }
    return false;
  }

  async getUser() {
    return await this.http
      .get<{ username: string }>(`${environment.apiServerUrl}/auth/user`, {
        withCredentials: true,
      })
      .toPromise();
  }

  async registerUser(user: User) {
    try {
      await this.http
        .post(`${environment.apiServerUrl}/auth/register`, user, {
          withCredentials: true,
        })
        .toPromise();
    } catch (error) {
      console.log('hit error', error);
    }
  }

  async getGames() {
    const resp = await this.http
      .get(`${environment.apiServerUrl}/game`, {
        withCredentials: true,
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .toPromise();
    console.log(resp);
  }
}
