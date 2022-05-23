import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { AuthService } from '../services/AuthService';

@Component({
  templateUrl: './signup.component.html',
})
export class SignupComponent implements OnInit {
  title: string = 'Sign Up';
  model: User = new User();

  constructor(private auth: AuthService) {}

  ngOnInit() {}

  async registerUser() {
    await this.auth.registerUser(this.model);
  }
}
