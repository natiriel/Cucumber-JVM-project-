$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Scenario.feature");
formatter.feature({
  "line": 2,
  "name": "English Premier League event",
  "description": "",
  "id": "english-premier-league-event",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@feature"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "As a WH Customer I want the ability to place a bet on a English Premier League event",
  "description": "",
  "id": "english-premier-league-event;as-a-wh-customer-i-want-the-ability-to-place-a-bet-on-a-english-premier-league-event",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@scenario"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Navigate to http://sports.williamhill.com/betting/en-gb",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Navigate to any football event",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Select event and place a \"0.15\" bet for the home team to Win",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Place bet and assert the odds and returns offered",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.Navigate_to_http_sports_williamhill_com_betting_en_gb()"
});
formatter.result({
  "duration": 5704302969,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs.Navigate_to_any_football_event()"
});
formatter.result({
  "duration": 1869169482,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.15",
      "offset": 26
    }
  ],
  "location": "StepDefs.select_event_and_place_a_bet_for_the_home_team_to_Win(String)"
});
formatter.result({
  "duration": 719231037,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs.Place_bet_and_assert_the_odds_and_returns_offered()"
});
formatter.result({
  "duration": 306085567,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs.Close_the_browser()"
});
formatter.result({
  "duration": 2311991484,
  "status": "passed"
});
});