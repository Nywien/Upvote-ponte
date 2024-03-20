import {Component} from '@angular/core';
import {IdeaService} from "../../services/idea.service";
import {NewIdeaListItemModel} from "../../models/newIdeaListItem.model";

@Component({
  selector: 'app-new-idea-list',
  templateUrl: './new-idea-list.component.html',
  styleUrls: ['./new-idea-list.component.css']
})
export class NewIdeaListComponent {
  ideas: NewIdeaListItemModel[] = [];

  constructor(private ideaService: IdeaService) {
  }

  listNewIdeas() {
    this.ideaService.getListNewIdeas().subscribe(
      (ideaList: NewIdeaListItemModel[]) => {
        this.ideas = ideaList;
      })
  }

  ngOnInit(): void {
    this.listNewIdeas();
  }

  acceptIdea(idea: NewIdeaListItemModel): void {
    const id = idea.id;
    this.ideaService.acceptIdea(id).subscribe(
      {
        complete:()=>{
          this.listNewIdeas();
        }
      }
    );
  }

  rejectIdea(idea: NewIdeaListItemModel): void {
    const id = idea.id;
    this.ideaService.rejectIdea(id).subscribe(
      {
        complete:()=>{
          this.listNewIdeas();
        }
      }
    );
  }
}
