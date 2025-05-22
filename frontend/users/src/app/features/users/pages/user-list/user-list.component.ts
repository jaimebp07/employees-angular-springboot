import { Component, OnInit, Signal } from '@angular/core';
import { UserStore } from '../../store/users.store';
import { User } from '../../models/user.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.scss',
})
export class UserListComponent implements OnInit {
  users: Signal<User[]>;
  loading: Signal<boolean>;

  constructor(private userStore: UserStore) {
    this.users = userStore.users;
    this.loading = userStore.loading;
  }

  ngOnInit(): void {
    this.userStore.loadingUsers();
  }
}
