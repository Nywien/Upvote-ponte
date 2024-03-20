import {Component, OnInit} from '@angular/core';
import {IdeaListItemModel} from "../../models/IdeaListItem.model";
import {IdeaService} from "../../services/idea.service";

@Component({
  selector: 'app-idea-list',
  templateUrl: './idea-list.component.html',
  styleUrls: ['./idea-list.component.css']
})
export class IdeaListComponent implements OnInit {

  ideas: IdeaListItemModel[] = [];

  constructor(private ideaService: IdeaService) {
  }

  listIdeas() {
    this.ideaService.getListIdeas().subscribe(
      (ideaList: IdeaListItemModel[]) => {
        this.ideas = ideaList;
      })
  }

  ngOnInit(): void {
    this.listIdeas();
  }

  addVote(idea: IdeaListItemModel): void {
    const id = idea.id;
    this.ideaService.addVote(id).subscribe(
      {
        complete: () => {
          this.listIdeas();
        }
      }
    );
  }
}
