

function getMatchesPerYear(matches)
{
    let matchesPerYear = {};
    for(let i =0; i < matches.length; i++){
        let season = matches[i]["season"];
        if(!matchesPerYear[season]){
            matchesPerYear[season] = 1;
        }
        else{
            matchesPerYear[season] += 1;
        }
    }

    return matchesPerYear;
}





function noOfMatchesWonPerYear(matches){
    let winTeamObject = {};
    for(let index = 0; index < matches.length; index++){
        let year = matches[index].season;
        let winner = matches[index].winner;
        let key = "TEAM" + "_" + winner + "_" + year;
        if(!winTeamObject[key]){
            winTeamObject[key] = 1;
        }
        else
        {
            winTeamObject[key] += 1;
        }
    }

    return winTeamObject;
}


// Extra runs conceded per team in the year 2016
function extraRuns2016(matches,deliveries,year)
{
    const extraRuns = {};
    const matchIdSeasonMap = {};
    for(let match of matches){
        let season = match.season;
        let id = match.id;
        matchIdSeasonMap[id] = season;
    }
     
    //console.log(matchIdSeasonMap);

    for(let delObj of deliveries){
        let matchId = delObj["match_id"];
        if(matchIdSeasonMap[matchId] == year){
            let exruns = parseInt(delObj.extra_runs);
            if(!extraRuns[delObj.batting_team]){
                  extraRuns[delObj.batting_team] = exruns;
            }
            else
            {
                extraRuns[delObj.batting_team] += exruns;
            }

        }
    }

    console.log(extraRuns);
    return extraRuns;
}



// Top 10 economical bowlers in the year 2015
function topEconomialBowler(matches,deliveries,year)
{
    const economyBowler = {};

    const matchIdSeasonMap = {};
    for(let match of matches){
        let season = match.season;
        let id = match.id;
        matchIdSeasonMap[id] = season;
    }


    for(let delObj of deliveries){
        let matchId = delObj["match_id"];
        if(matchIdSeasonMap[matchId] == year){
         
            if(economyBowler[delObj.bowler] !== undefined){
                economyBowler[delObj.bowler][0] += parseInt(delObj.total_runs);
                economyBowler[delObj.bowler][1] += parseInt(delObj.ball);
            }
            else
            {
                // for each bowler create property of bowler name and
                // in value push the totalruns and overs
                economyBowler[delObj.bowler] = [];
                economyBowler[delObj.bowler].push(parseInt(delObj.total_runs),(parseInt(delObj.ball)));
            }

        }
    }


    let Arr = [];
    for(let key in economyBowler){
        let runs = Math.floor(economyBowler[key][0]);
        let over = Math.floor(economyBowler[key][1] / 6);
        let value = runs/over;
        Arr.push([key,value]);
    }

    Arr.sort(function(a,b){
        return a[1] - b[1];
    });

    let outputArr = [];
    for(let i =0; i < 10; i++){
        console.log(Arr[i]);
        outputArr.push(Arr[i]);
    }


}


module.exports = {
    getMatchesPerYear,
    noOfMatchesWonPerYear,
    extraRuns2016,
    topEconomialBowler,


};