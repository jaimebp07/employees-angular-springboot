import { Injectable, signal } from "@angular/core";
import { User } from "../models/user.model";
import { UserApiService } from "../services/user.service";


@Injectable({ providedIn: 'root' })
export class UserStore {

    private readonly _users = signal<User[]>([]);
    readonly users = this._users.asReadonly();

    private readonly _loading = signal<boolean>(false);
    readonly loading = this._loading.asReadonly();

    constructor(private userApiService: UserApiService){
        console.log("HOLAAAAAAAAAAAAAAAAAAAAAA")
    }

    loadingUsers(){
        this._loading.set(true);
        this.userApiService.getAllUsers().subscribe({
            next: value => {
                this._users.set(value);
                this._loading.set(false);
            }
        });
    }

}