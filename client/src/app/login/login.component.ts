import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { AuthService } from '../services/AuthService';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {
  model: User = new User();
  constructor(private auth: AuthService) {}

  ngOnInit(): void {}

  async login() {
    return this.auth.login(this.model.username, this.model.password);
  }

  async getGames() {
    this.auth.getGames();
  }
}
