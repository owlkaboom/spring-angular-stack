import { Component, Output } from '@angular/core';
import { AuthService } from '../services/AuthService';

@Component({
  templateUrl: './home.component.html',
})
export class HomeComponent {
  title = 'Home';
  @Output() games: any[] = [];
  constructor(private auth: AuthService) {}

  get isLoggedIn(): boolean {
    return this.auth.loggedInUser !== undefined;
  }

  async getGames() {
    this.games = await this.auth.getGames();
  }
}
