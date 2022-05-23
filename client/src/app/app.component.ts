import { Component } from '@angular/core';
import { User } from './model/User';
import { AuthService } from './services/AuthService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'client';

  constructor(private auth: AuthService) {}

  isLoggedIn() {
    return !!this.auth.loggedInUser;
  }
}
