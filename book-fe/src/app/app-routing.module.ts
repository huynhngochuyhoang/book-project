import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {BookItemComponent} from "./components/book-list/book-item/book-item.component";

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: ":id", component: BookItemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
