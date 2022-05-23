import { Component } from '@angular/core';
import { AuthService } from '../services/AuthService';

@Component({
  templateUrl: './home.component.html',
})
export class HomeComponent {
  title = 'Home';
  constructor(private auth: AuthService) {}

  get isLoggedIn(): boolean {
    return this.auth.loggedInUser !== undefined;
  }

  async getGames() {
    await this.auth.getGames();
  }
}
